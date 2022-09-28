# https://leetcode.com/problems/longest-common-subsequence/


text1 = "abcde"
text2 = "ace"

text3 = "bsbininm"
text4 = "jmjkbkjkv"

text5 = "abcba"
text6 = "abcbcba"

def longestCommonSubsequence(text1: str, text2: str) -> int:
    t1 = list(text1)
    t2 = list(text2)
    result = [["" for x in range(len(t1) + 1)] for y in range(len(t2) + 1)]
    
    for i in range(len(t2)):
        for j in range(len(t1)):
            if i == 0 or j == 0:
                result[i][j] = ""

            if t2[i] == t1[j]:
                result[i+1][j+1] = result[i+1-1][j+1-1] + t2[i]
            else:   
                if len(result[i+1-1][j+1]) > len(result[i+1][j+1-1]):
                    result[i+1][j+1] = result[i+1-1][j+1]
                else:
                    result[i+1][j+1] = result[i+1][j+1-1]
                
    print(result[len(t2)][len(t1)])
    return 0

longestCommonSubsequence(text1, text2)
longestCommonSubsequence(text3, text4)