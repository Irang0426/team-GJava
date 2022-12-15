import sys

N, M = map(int, sys.stdin.readline().split())
lsitA = list(map(int, sys.stdin.readline().split()))
lsitB = list(map(int, sys.stdin.readline().split()))

indexA, indexB = 0, 0

answer = []
while indexA <= N and indexB <= M :
    
    if indexA == N and indexB == M :
        break
    
    if indexA == N :
        answer.append(listB[indexB])
        indexB += 1
        
    elif indexB == M :
        answer.append(listA[indexA])
        indexA += 1
    
    elif listA[indexA] < listB[indexB] :
        answer.append(listA[indexA])
        indexA += 1
        
    else :
        answer.append(listB[indexB])
        indexB += 1
        
print(*answer)