import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline())
    list = list(map(int, sys.stdin.readline().split()))
    x = int(sys.stdin.readline())

    list.sort()

    indexA = 0
    indexB = n - 1
    count = 0

    while indexA < indexB:
        if list[indexA] + list[indexB] == x:
            count += 1
            indexA += 1

        elif list[indexA] + list[indexB] > x:
            indexB -= 1

        else:
            indexA += 1

    print(count)
