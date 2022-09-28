# https://www.nowcoder.com/questionTerminal/6fe0302a058a4e4a834ee44af88435c7

test1 = [2,5,20]
test2 = [1,100,1,1,1,90,1,1,80,1]

def minCostClimbingStairs(cost: list[int]) -> int:
    result = [None] * (len(cost) + 1)
    result[0] = 0
    result[1] = 0
    
    for i in range(2, len(cost) + 1):
        result[i] = min(result[i-1] + cost[i-1], result[i-2] + cost[i-2])
    return result[-1]



print(minCostClimbingStairs(test2))
 