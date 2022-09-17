class Stack:
    """
    Class implementing Stack data structure
    """

    def __init__(self):
        """
        Initialize stack with a python list
        """
        self.stack_list = []

    def push(self, element) -> None:
        """
        Function to push (add) an element on the top of the stack
        Args:
            element: element to be pushed to the top of the stack
        Returns: None
        """
        self.stack_list.append(element)

    def pop(self):
        """
        Function to pop (remove) an element from the top of the stack
        Args: NA
        Returns: Removes and returns an element at the top of the stack. Returns None if the stack is empty
        """
        if self.is_empty():
            # Return None if the stack is empty
            return None

        return self.stack_list.pop()

    def peek(self):
        """
        Function to peek at but not pop out an element at the top of the stack
        Args: NA
        Returns: Returns an element at the top of the stack without removing it from the stack. Returns None if the stack is empty
        """
        if self.is_empty():
            # Return None if the stack is empty
            return None

        return self.stack_list[-1]

    def is_empty(self) -> bool:
        """
        Function to check if the stack is empty
        Args: NA
        Returns: boolean indicating whether the stack is empty or not
        """
        return self.size() == 0

    def size(self) -> int:
        """
        Function to get the size of the stack
        Args: NA
        Returns: integer indicating the current size / number of elements in the stack
        """
        return len(self.stack_list)
