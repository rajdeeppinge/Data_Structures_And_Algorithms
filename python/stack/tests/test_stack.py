import unittest

from stack.stack import Stack


class TestStack(unittest.TestCase):
    def test_stack_initialization(self):
        """
        Test initialization of stack
        """
        stack = Stack()

        expected_stack_is_empty = True
        self.assertEqual(stack.is_empty(), expected_stack_is_empty)

    def test_stack_push(self):
        """
        Test stack push function
        """
        stack = Stack()

        element = 10
        stack.push(element=element)

        element = 5
        stack.push(element=element)

        element = 20
        stack.push(element=element)

        expected_stack_size = 3
        self.assertEqual(stack.size(), expected_stack_size)

    def test_stack_peek(self):
        """
        Test stack peek function
        """
        stack = Stack()

        # call peek on empty stack
        expected_top_of_stack = None
        top_of_stack = stack.peek()
        self.assertEqual(top_of_stack, expected_top_of_stack)

        element = 10
        stack.push(element=element)

        element = 5
        stack.push(element=element)

        element = 20
        stack.push(element=element)

        expected_top_of_stack = element

        top_of_stack = stack.peek()
        self.assertEqual(top_of_stack, expected_top_of_stack)

        # peeking a second time should not change the top element as peek does not remove it from stack
        top_of_stack = stack.peek()
        self.assertEqual(top_of_stack, expected_top_of_stack)

    def test_stack_pop(self):
        """
        Test stack pop function
        """
        stack = Stack()

        element = 10
        stack.push(element=element)

        element = 5
        stack.push(element=element)

        element = 20
        stack.push(element=element)

        # pop 1
        expected_top_of_stack = element
        top_of_stack = stack.pop()
        self.assertEqual(top_of_stack, expected_top_of_stack)

        expected_size = 2
        self.assertEqual(stack.size(), expected_size)

        # pop another
        expected_top_of_stack = 5
        top_of_stack = stack.pop()
        self.assertEqual(top_of_stack, expected_top_of_stack)

        expected_size = 1
        self.assertEqual(stack.size(), expected_size)

        # pop one more
        expected_top_of_stack = 10
        top_of_stack = stack.pop()
        self.assertEqual(top_of_stack, expected_top_of_stack)

        expected_size = 0
        self.assertEqual(stack.size(), expected_size)

        # try to pop from empty stack
        expected_top_of_stack = None
        top_of_stack = stack.pop()
        self.assertEqual(top_of_stack, expected_top_of_stack)

        expected_size = 0
        self.assertEqual(stack.size(), expected_size)


if __name__ == "__main__":
    unittest.main()
