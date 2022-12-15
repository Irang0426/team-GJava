import sys

T = int(sys.stdin.readline())
while T > 0 :
    a, b, c = map(int, sys.stdin.readline().split(' '))
    print(min(a, min(b, c)))
    T -= 1