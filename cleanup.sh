#!/bin/sh
rm -rf .idea
cp icon.svg .idea/icon.svg
./gradlew clean
rm -rf .gradle
rm -rf build
rm -rf */build
rm -rf ios/iosApp.xcworkspace
rm -rf ios/Pods
rm -rf ios/iosApp.xcodeproj/project.xcworkspace
rm -rf ios/iosApp.xcodeproj/xcuserdata
