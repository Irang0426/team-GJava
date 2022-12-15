import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    L = []
    for i in range(1, N + 1):
        L.append(i)

    left, right = 1, 1
    count = 0

    while right <= N:
        total = 0
        for i in range(left, right + 1):
            total += i

        if total == N:
            count += 1
            right += 1

        elif total < N:
            right += 1

        else:
            left += 1

    print(count)
