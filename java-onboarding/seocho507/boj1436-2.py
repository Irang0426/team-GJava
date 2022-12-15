import sys

if __name__ == "__main__" :
    N = int(sys.stdin.readline())
    number = 0
    count = 0
    
    while count != N:
        if '666' in str(number) :
            count += 1
        number += 1
        
    print(number-1)