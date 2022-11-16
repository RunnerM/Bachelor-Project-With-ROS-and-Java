#!/usr/bin/env python
PKG = 'test_foo'
import unittest


# A sample python unit test
class TestBareBones(unittest.TestCase):

    def test_one_equals_one(self):
        self.assertEquals(1, 1, "1!=1")


if __name__ == '__main__':
    import rosunit
    rosunit.unitrun(PKG, 'test_bare_bones', TestBareBones)
