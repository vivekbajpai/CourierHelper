# CourierHelper
Assignment

## Build the code

```
D:\SprinBoot\CourierService\CourierHelper>gradle build
Java HotSpot(TM) 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

BUILD SUCCESSFUL in 4s
7 actionable tasks: 5 executed, 2 up-to-date
D:\SprinBoot\CourierService\CourierHelper>gradle build
Java HotSpot(TM) 64-Bit Server VM warning: Sharing is only supported for boot loader classes because bootstrap classpath has been appended

BUILD SUCCESSFUL in 5s
7 actionable tasks: 7 executed
D:\SprinBoot\CourierService\CourierHelper>
```

## Run Application

Copy the config.properties and offers.csv from the project to the build location

<img width="1143" height="319" alt="image" src="https://github.com/user-attachments/assets/beb6214e-1ced-4277-84e4-dda0ae16d731" />

run `java -jar CourierHelper-0.0.1-SNAPSHOT.jar`

```
D:\SprinBoot\CourierService\CourierHelper\build\libs>java -jar CourierHelper-0.0.1-SNAPSHOT.jar

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v3.5.7)

2025-10-26T16:18:35.232+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.helper.CourierHelperApplication      : Starting CourierHelperApplication v0.0.1-SNAPSHOT using Java 17.0.12 with PID 22908 (D:\SprinBoot\CourierService\CourierHelper\build\libs\CourierHelper-0.0.1-SNAPSHOT.jar started by VivekBajpai in D:\SprinBoot\CourierService\CourierHelper\build\libs)
2025-10-26T16:18:35.235+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.helper.CourierHelperApplication      : No active profile set, falling back to 1 default profile: "default"
2025-10-26T16:18:35.751+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.helper.CourierHelperApplication      : Started CourierHelperApplication in 0.905 seconds (process running for 1.263)
###################################################################
####################################################################
###############     Hello, Welcome to Courier Service    ############
Enter 1 for Package cost Estimations.
      2 for Package Delivery Estimations.
Enter Option: 2
Enter Base Price and Package Count e.g. 100 3: 100 5
Enter Details for Package Item: 1
Enter Package details as pkg_Id weight distance offer_code e.g PKG1 10 20 OFR001: PKG1 50 30 OFR001
Enter Details for Package Item: 2
Enter Package details as pkg_Id weight distance offer_code e.g PKG1 10 20 OFR001: PKG2 75 125 OFR008
Enter Details for Package Item: 3
Enter Package details as pkg_Id weight distance offer_code e.g PKG1 10 20 OFR001: PKG3 175 100 OFR003
Enter Details for Package Item: 4
Enter Package details as pkg_Id weight distance offer_code e.g PKG1 10 20 OFR001: PKG4 155 95 OFR002
checkOfferWeight
Enter Details for Package Item: 5
Enter Package details as pkg_Id weight distance offer_code e.g PKG1 10 20 OFR001: PKG5 110 60 OFR002
checkOfferWeight
Enter vehicle details as no_of_vehicles max_speed max_carriable_weight e.g 2 70 200: 2 70 200
2025-10-26T16:22:00.035+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Configuaring vehicles.2
2025-10-26T16:22:00.037+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Excluding heavey packages from the trip.
2025-10-26T16:22:00.042+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Creating the delivery trips
2025-10-26T16:22:00.043+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Schedulings Trips.
2025-10-26T16:22:00.044+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Calculating Total Trip time for trip.trip_1
[Package [id=PKG1, weight=50.0, diatance=30.0, offer=OFR001, cost=750.0, discount=0.0, deliveryTime=0.0], Package [id=PKG2, weight=75.0, diatance=125.0, offer=OFR008, cost=1475.0, discount=0.0, deliveryTime=0.0]]
Package [id=PKG2, weight=75.0, diatance=125.0, offer=OFR008, cost=1475.0, discount=0.0, deliveryTime=0.0]
2025-10-26T16:22:00.054+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Calculating Total Trip time for trip.trip_2
[Package [id=PKG3, weight=175.0, diatance=100.0, offer=OFR003, cost=2350.0, discount=0.0, deliveryTime=0.0]]
Package [id=PKG3, weight=175.0, diatance=100.0, offer=OFR003, cost=2350.0, discount=0.0, deliveryTime=0.0]
2025-10-26T16:22:00.065+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Calculating Total Trip time for trip.trip_3
[Package [id=PKG4, weight=155.0, diatance=95.0, offer=OFR002, cost=1976.25, discount=148.75, deliveryTime=0.0]]
Package [id=PKG4, weight=155.0, diatance=95.0, offer=OFR002, cost=1976.25, discount=148.75, deliveryTime=0.0]
2025-10-26T16:22:00.067+05:30  INFO 22908 --- [CourierHelper] [           main] c.c.h.i.PackageDeliveryTimeEstimation    : Calculating Total Trip time for trip.trip_4
[Package [id=PKG5, weight=110.0, diatance=60.0, offer=OFR002, cost=1395.0, discount=105.00000000000001, deliveryTime=0.0]]
Package [id=PKG5, weight=110.0, diatance=60.0, offer=OFR002, cost=1395.0, discount=105.00000000000001, deliveryTime=0.0]

Package delivery time estimation

PKG1 0.0 750.0 0.42857142857142855
PKG2 0.0 1475.0 1.7857142857142858
PKG3 0.0 2350.0 1.4285714285714286
PKG4 148.75 1976.25 4.214285714285714
PKG5 105.00000000000001 1395.0 4.428571428571429

Delivery Trips:

trip_1 [Package [id=PKG1, weight=50.0, diatance=30.0, offer=OFR001, cost=750.0, discount=0.0, deliveryTime=0.42857142857142855], Package [id=PKG2, weight=75.0, diatance=125.0, offer=OFR008, cost=1475.0, discount=0.0, deliveryTime=1.7857142857142858]] vehicle_1
trip_2 [Package [id=PKG3, weight=175.0, diatance=100.0, offer=OFR003, cost=2350.0, discount=0.0, deliveryTime=1.4285714285714286]] vehicle_2
trip_3 [Package [id=PKG4, weight=155.0, diatance=95.0, offer=OFR002, cost=1976.25, discount=148.75, deliveryTime=4.214285714285714]] vehicle_2
trip_4 [Package [id=PKG5, weight=110.0, diatance=60.0, offer=OFR002, cost=1395.0, discount=105.00000000000001, deliveryTime=4.428571428571429]] vehicle_1

D:\SprinBoot\CourierService\CourierHelper\build\libs>
```
