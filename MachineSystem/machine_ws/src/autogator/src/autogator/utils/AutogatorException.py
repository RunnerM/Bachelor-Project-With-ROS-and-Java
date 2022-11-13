from enum import Enum


class ErrorReasons(Enum):
    """Error reasons for autogator robot."""
    UNKNOWN = 0
    GPS = 1
    MOTOR = 2
    NETWORK = 3
    OTHER = 4


class AutogatorException(Exception):
    """Base class for exceptions in autogato package."""
    pass


class AutogatorNodeException(AutogatorException):
    """Exception raised for errors in the autogator robot.

    Attributes:
        node -- node that raised the exception
        message -- explanation of the error
    """

    def __init__(self, node, message):
        self.node = node
        self.message = message


class AutogatorFatalException(AutogatorException):
    """Exception raised for errors in the autogator robot.

    Attributes:
        node -- node that raised the exception
        message -- explanation of the error
        cause -- cause of the error
    """

    def __init__(self, node, message, reason=ErrorReasons.UNKNOWN):
        self.node = node
        self.message = message
        self.reason = reason
