# https://app.codesignal.com/interview-practice/task/xrFgR63cw7Nch4vXo/description

dishes = [["Salad", "Tomato", "Cucumber", "Salad", "Sauce"],
            ["Pizza", "Tomato", "Sausage", "Sauce", "Dough"],
            ["Quesadilla", "Chicken", "Cheese", "Sauce"],
            ["Sandwich", "Salad", "Bread", "Tomato", "Cheese"]]
            
def solution(dishes):
    dict = {}
    for i in dishes:
        for j in range(1, len(i)):
            if i[j] in dict:
                dict[i[j]].add(i[0])
            else:
                dict[i[j]] = {i[0]}
    dict = sorted([i] + sorted(v) for i, v in dict.items() if len(v) > 1)
    print(dict)

solution(dishes)