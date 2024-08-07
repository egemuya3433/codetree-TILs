n = int(input())

arr = []
for _ in range(n):
    a = int(input())
    arr.append(a)
# a = [1 2 3 1 1 5]
s_1, s_2 = list(map(int, input().split()))
s_3, s_4 = list(map(int, input().split()))


def slice_a(arr, s, e): # arr, 2, 4 
    temp = []
    for i in range(len(arr)):
        if i < s-1 or i > e-1:
            temp.append(arr[i])
    arr = temp 
    return arr

def process():
    arr1 = slice_a(arr, s_1, s_2)
    arr2 = slice_a(arr1, s_3, s_4)
    print(len(arr2))
    for a in arr2:
        print(a)
process()