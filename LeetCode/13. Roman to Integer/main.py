def romanToInt(s: str) -> int:
    m = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}

    if len(s) < 1:
        return 0

    l = list(s)
    sum = m[l[0]]

    for i in range(1, len(l)):
        if m[l[i-1]] < m[l[i]]:
            sum = sum - (2 * m[l[i-1]])
        sum = sum + m[l[i]]
    return sum

s = "III"
s1 = "XIV"
s2 = "MCMXCIV" #1994
print(romanToInt(s2))