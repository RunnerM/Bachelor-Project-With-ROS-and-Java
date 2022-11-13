Setup test environment

Get and build Docker environment

    $ cd ~/PATH/TO/WORKSPACE/
    $ git clone git@bitbucket.org:conpleksdev/docker-rosdev.git
    $ cd docker-rosdev
    $ ./setup.sh
    $ cp rosdev ~/PATH/TO/WORKSPACE/

Build in Indigo

    $ cd ~/PATH/TO/WORKSPACE/
    $ ./rosdev indigo
    $ catkin_make
    $ source setup_dev.bash

In rosdev indigo, the Gazebo simulator can now be launched with

    $ roslaunch stadion stadion.launch

Join Docker with new terminal ("5a60a29d596d" = container id): (change ros_base and ros_sim to what you are using)

    $ docker ps
    $ docker exec -it 5a60a29d596d /bin/bash
    $ source setup_dev.bash
    $ roslaunch ros_base ros_sim.launch

The tablet application can now be connected to the PC use ip on PC:

    $ hostname -I
