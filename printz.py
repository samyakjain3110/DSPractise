

n = 5
for row in range(1,n+1):
    for col in range(1,n+1):
        if(row == 1 or row == n ):
            print(col,end='')
        elif(row + col == n):
            print(col,end='')
        else:
            print(" ",end='')
    print("\n")