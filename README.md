## Woodwing Coding Test

This project implements a REST API 

#### Calculate total distance
**GET** /distance

**URL parameters**
dist=[double][string]..
example: dist=1m&dist=1yd
no dist arg defaults to 0m

unit=[string]
empy unit arg defaults to m
recognizd units are
- m (metre)
- yd (yard)
- km (kilometre)
- mi (mile

