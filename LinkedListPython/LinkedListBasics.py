class Node:
    def __init__(self, key):
        self.key = key
        self.next = None



def Printfun1(head):
    if(head is not None):
        print(head.key)
        Printfun1(head.next)


def Printfun2(head):
    curr = head
    if(curr is not None):
        print(curr.key)
        curr = curr.next




if __name__ == '__main__':

    head = Node(10)


    Printfun2(head)
