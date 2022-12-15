import sys
from collections import deque

n = int(sys.stdin.readline())
m = int(sys.stdin.readline())
adj = [[] for _ in range(n + 1)]

for _ in range(m):
    x, y = list(map(int, sys.stdin.readline().split(' ')))
    adj[x].append(y)
    adj[y].append(x)

for i in range(1, n + 1):
    adj[i].sort()

visit = [0] * (n + 1)


def dfs(k):
    visit[k] = 1

    for y in adj[k]:
        if visit[y] == 1:
            continue
        dfs(y)


def bfs(x):
    queue = deque()
    queue.append(x)
    visit[x] = 1
    while queue:
        x = queue.popleft()
        for y in adj[x]:
            if visit[y]:
                continue
            visit[y] = 1
            queue.append(y)


dfs(1)

print(sum(visit) - 1)
