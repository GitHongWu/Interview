#!/usr/bin/env python 
# -*- coding:utf-8 -*-

import tkinter as tk
from urllib.request import urlopen
from bs4 import BeautifulSoup as bs


class Application(tk.Frame):
    def __init__(self, parent, *args, **kwargs):
        tk.Frame.__init__(self, parent, *args, **kwargs)
        self.parent = parent

        root.geometry('700x300')
        root.title('Stock Info Application')

        self.grid_columnconfigure(0, weight=1)

        # create frames
        self.frame_mainpage = tk.Frame(root)
        # self.frame_query = tk.Frame(root)
        # self.frame_query2 = tk.Frame(root)
        frames = [self.frame_mainpage]
        for frame in frames:
            frame.grid(row=0, column=0, sticky='news')

        self.create_frame_mainpage(self.frame_mainpage)
        self.raise_frame(self.frame_mainpage)

    def create_frame_mainpage(self, frame):
        print('create frame mainpage')

        # create basic elements
        label_prompt = tk.Label(frame, text="\nPlease enter stock code\n", font=("Courier", 12))
        label_prompt.grid(row=0, column=0, sticky=tk.W, padx=20, columnspan=2)
        search_field = tk.Entry(frame, width=10, font=10)
        search_field.grid(row=1, column=0, padx=20)
        search_button = tk.Button(frame, text='Search', width=10, command=lambda: self.query(element_list))
        search_button.grid(row=1, column=1, sticky=tk.W)
        # message label, stock name and etc
        message_label = tk.Label(frame, text='\n')
        message_label.grid(row=2)
        stock_label = tk.Label(frame, text="Stock Name:", font=("Courier", 12))
        stock_label.grid(row=3, column=0, sticky=tk.W, padx=20)
        stock_name = tk.Label(frame, font=("Courier", 12))
        stock_name.grid(row=3, column=1, sticky=tk.W, padx=20)

        label_high = tk.Label(frame, text="High Price:", font=("Courier", 12))
        label_high.grid(row=4, column=0, sticky=tk.W, padx=20)
        high_price = tk.Label(frame, font=("Courier", 12))
        high_price.grid(row=4, column=1, sticky=tk.W, padx=20)

        label_low = tk.Label(frame, text="Low Price:", font=("Courier", 12))
        label_low.grid(row=5, column=0, sticky=tk.W, padx=20)
        low_price = tk.Label(frame, font=("Courier", 12))
        low_price.grid(row=5, column=1, sticky=tk.W, padx=20)

        label_open = tk.Label(frame, text="Open Price:", font=("Courier", 12))
        label_open.grid(row=6, column=0, sticky=tk.W, padx=20)
        open_price = tk.Label(frame, font=("Courier", 12))
        open_price.grid(row=6, column=1, sticky=tk.W, padx=20)

        label_close = tk.Label(frame, text="Previous Close Price:", font=("Courier", 12))
        label_close.grid(row=7, column=0, sticky=tk.W, padx=20)
        close_price = tk.Label(frame, font=("Courier", 12))
        close_price.grid(row=7, column=1, sticky=tk.W, padx=20)

        # store all need update elements into a list
        element_list = [search_field, message_label, stock_name, high_price, low_price, open_price, close_price]

    # function called when button clicked
    # args: elements_list(contains elements that needs to update after button clicked)
    #   elements_list index:
    #       0: search_field (clear every time when user click button)
    #       1: message_label (display message, such as collecting data, error etc.)
    #       2: stock_name (if the given stock code is valid, the name of the stock should display)
    #       3: high_price   4: low_price    5: open_price   6: close_price
    def query(self, element_list):
        user_input = element_list[0].get()
        if not user_input:
            element_list[1]['text'] = 'Please enter a stock code\n'
            return
        print('user input: ', user_input)

        source_url = 'https://finance.yahoo.com/quote/'
        target_url = source_url + user_input
        print('url: ' + target_url)

        # clear data field
        self.clear_all(element_list)
        element_list[1]['text'] = 'Collecting data...\n'

        # if stock code is valid, store data into content[]
        content = []
        if self.valid_stock_code(target_url, content):
            element_list[1]['text'] = 'Collecting data...\n'
            print('valid code')
            print(content[0].find('h1'))
            # update stock name
            element_list[2]['text'] = content[0].find('h1').text

            # update other prices
            # Connect to the website and return the html to the variable ‘page’
            page = urlopen(target_url)
            # parse the html using beautiful soup and store in variable `soup`
            soup = bs(page, 'html.parser')
            prices = soup.select('table td')
            low_high_price = prices[9].text
            low_high_price_list = low_high_price.split()
            print('prices list: ', low_high_price_list)
            # if day range is N/A, append N/A twice as high and low price
            if len(low_high_price_list) != 3:  # N/A
                element_list[3]['text'] = low_high_price_list[0]    # high price
                element_list[4]['text'] = low_high_price_list[0]    # low price
            else:
                element_list[3]['text'] = low_high_price_list[2]  # high price
                element_list[4]['text'] = low_high_price_list[0]  # low price

            # searching for open and close price
            element_list[5]['text'] = prices[3].text   # open price
            element_list[6]['text'] = prices[1].text  # close price
            print('open: ' + prices[3].text)
            print('close: ' + prices[1].text)

            element_list[1]["text"] = '\n'
        else:
            print('Invalid code')
            element_list[1]['text'] = 'Invalid stock code\n'

    # check if given stock code has stock name, high, low, open anc close price.
    # return these stock name and prices
    def valid_stock_code(self, url, content):
        try:
            # Connect to the website and return the html to the variable ‘page’
            page = urlopen(url)
            # parse the html using beautiful soup and store in variable `soup`
            soup = bs(page, 'html.parser')
            # searching stock name by div class name
            stock_name = soup.find('div', class_='D(ib) Mt(-5px) Mend(20px) Maw(56%)--tab768 Maw(52%) Ov(h) smartphone_Maw(85%) smartphone_Mend(0px)')
            content.append(stock_name)
            # beautifulSoup.find return None if not found
            if stock_name is None:
                print('content: None')
                return False
            return True
        except:
            print("Error opening the URL")
        return False

    def clear_all(self, element_list):
        element_list[0].delete(0, tk.END)
        element_list[1]['text'] = '\n'
        for i in range(2, 7):
            element_list[i]['text'] = ''

    @staticmethod
    def raise_frame(frame):
        frame.tkraise()


if __name__ == "__main__":
    root = tk.Tk()
    Application(root).grid(sticky="nsew")
    root.grid_rowconfigure(0, weight=1)
    root.grid_columnconfigure(0, weight=1)
    root.mainloop()
