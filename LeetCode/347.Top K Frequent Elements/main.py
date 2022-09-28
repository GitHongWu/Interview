from collections import Counter

def topKFrequent(nums, k):
    freq = Counter(nums)
    sorted_freq = dict(sorted(freq.items(), key=lambda x: x[1], reverse=True))
    return list(sorted_freq.keys())[:k]

input = [1,1,1,1,2,2,3]
print(topKFrequent(input, 2))
