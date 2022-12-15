import sys

def count6(n):
    cnt = 0
    while n > 0:
        if n % 10 == 6:
            cnt += 1
        else:
            cnt = 0
        if cnt >= 3:
            return True
        n = n // 10

    return False


if __name__ == "__main__":
    N = int(sys.stdin.readline())

    answer = 665

    while N > 0:
        answer += 1
        if count6(answer):
            N -= 1

    print(answer)