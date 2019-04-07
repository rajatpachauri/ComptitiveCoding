
class Node:
    def __init__(self, data):
        self.data  = data
        self.next = None

class LinkedList:

    def __init__(self):
        self.head = None
        self.tail = None

    def traverse(self):
        temp = self.head
        while(temp):
            print(temp.data)
            temp = temp.next

if __name__ == '__main__':

    llist = LinkedList()
    llist.head = Node(1)
    second = Node(2)
    third  = Node(3)
    llist.tail  = Node(4)

    llist.head.next = second
    second.next = third
    third.next = llist.tail
    llist.traverse()


