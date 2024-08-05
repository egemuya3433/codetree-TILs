n, t = list(map(int, input().split()))

one = list(map(int, input().split()))
two = list(map(int, input().split()))
three = list(map(int, input().split()))

three = three[::-1]
for _ in range(t):
    temp1 = one[-1]
    temp2 = two[-1]
    temp3 = three[0]

    for i in range(n-1, 0, -1):
        one[i] = one[i-1]
    one[0] = temp3
    for i in range(n-1, 0, -1):
        two[i] = two[i-1]
    two[0] = temp1
    for i in range(0, n-1):
        three[i] = three[i+1]
    three[-1] = temp2
three = three[::-1]

for i in one:
    print(i, end = ' ')
print()
for i in two:
    print(i, end = ' ')
print()
for i in three:
    print(i, end = ' ')