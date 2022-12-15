import sys

def distance(a, b):
    if len(a) != len(b):
        return -1
    ret = 0
    for j in range(len(a)):
        if a[j] != b[j]:
            ret += 1
    return ret


if __name__ == "__main__":
    A, B = sys.stdin.readline().split()

    answer = len(A)

    for i in range(len(B) - len(A) + 1):
        diff = distance(A, B[i:(i+len(A))])
        if diff < answer:
            answer = diff

    print(answer)