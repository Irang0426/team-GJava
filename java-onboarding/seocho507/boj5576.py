import sys

if __name__ == "__main__" :
    list_w = []
    list_k = []
    for _ in range(10) :
        list_w.append(int(sys.stdin.readline()))
    
    for _ in range(10) :
        list_k.append(int(sys.stdin.readline()))
        
    list_w.sort()
    list_k.sort()
    
    sum_w = list_w[9] + list_w[8] + list_w[7]
    sum_k = list_k[9] + list_k[8] + list_k[7]
    
    print(sum_w, sum_k)