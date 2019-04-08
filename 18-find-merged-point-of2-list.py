#!/bin/python3

import math
import os
import random
import re
import sys

class SinglyLinkedListNode:
    def __init__(self, node_data):
        self.data = node_data
        self.next = None

class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None

    def insert_node(self, node_data):
        node = SinglyLinkedListNode(node_data)

        if not self.head:
            self.head = node
        else:
            self.tail.next = node


        self.tail = node

def print_singly_linked_list(node, sep, fptr):
    while node:
        fptr.write(str(node.data))

        node = node.next

        if node:
            fptr.write(sep)

def reverse(head):
    if head == None or head.next == None:
        return head

    remaining = reverse(head.next)
    
    head.next.next = head
    head.next = None

    return remaining


# Complete the has_cycle function below.

#
# For your reference:
#
# SinglyLinkedListNode:
#     int data
#     SinglyLinkedListNode next
#
#
def findMergeNode(head1, head2):
    temp1 = head1
    temp2 = head2
    while temp1 != temp2:
        if temp1.next == None:
            return temp1.data
        else:
            temp1 = temp1.next

        if temp2.next == None:
            return temp2.data
        else:
            temp2 = temp2.next
    
    return temp1.data
    
    # head1 = reverse(head1)
    # head2 = reverse(head2)
    # previous = head1
    # while head1 == head2:
    #     previous = head1
    #     head1 = head1.next
    #     head2 = head2.next
    # return previous.data
