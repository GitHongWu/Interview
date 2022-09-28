def productExceptSelf(nums):
        pre = [1]
        for i in range(1, len(nums)):
            pre.append(pre[i-1]*nums[i-1])
        
        post = [1]
        for j in range(len(nums)-2, -1, -1):
            post = [nums[j+1]*post[0]] + post
        
        res = []
        for i in range(len(nums)):
            res.append(post[i]*pre[i])
        return res

nums = [1,2,3,4]
print(productExceptSelf(nums))