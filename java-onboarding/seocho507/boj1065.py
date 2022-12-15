import sys


N = int(sys.stdin.readline())
answer = 0
count = 0
    
if N < 100 :
    answer = N
    print(answer)

elif N >= 100 :
    count = 99

    for i in range(100, N+1) :
        digit = list(map(int, str(i)))
        # for num in digit:
        #     print(num)
        if digit[0] - digit[1] == digit[1] - digit[2] :
            count += 1
    
    answer = count
    print(answer)