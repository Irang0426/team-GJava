import sys
import math

def bisect(n) :
    left, right = 1, n-1
    
    while left <= right :
        mid = (left + right) // 2
        
        if mid < math.sqrt(n) :
            left = mid + 1
        
        else:
            right = mid - 1
            
    return left

if __name__ == "__main__" :
    N = int(sys.stdin.readline())
    print(bisect(N))
    
    