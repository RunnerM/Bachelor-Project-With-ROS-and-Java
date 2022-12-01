import rospy
from autogator.msg import DiagnosticArray, DiagnosticStatus

if __name__ == '__main__':
    rospy.init_node('base_node')
    pub = rospy.Publisher('/diagnostics', DiagnosticArray, queue_size=1)

    arr = DiagnosticArray()
    arr.status = [
        DiagnosticStatus(name='gps gps message', message='the gps message'),
        DiagnosticStatus(name='motor motor message', message='the battery message')
    ]

    rate = rospy.Rate(1)
    while not rospy.is_shutdown():
        arr.header.stamp = rospy.Time.now()
        pub.publish(arr)
        rate.sleep()
    pass
