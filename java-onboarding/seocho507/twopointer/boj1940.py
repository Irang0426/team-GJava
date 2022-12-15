import sys

if __name__ == "__main__":
    N = int(sys.stdin.readline())
    M = int(sys.stdin.readline())
    L = list(map(int, sys.stdin.readline().split()))
    L.sort()
    indexA = 0
    indexB = N - 1
    count = 0

    while indexA < indexB:
        if L[indexA] + L[indexB] == M:
            count += 1
            indexA += 1

        elif L[indexA] + L[indexB] > M:
            indexB -= 1

        else:
            indexA += 1

    print(count)
