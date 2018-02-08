if [ -z $1 ]; then

  cp tests/testng1.xml testng.xml
  echo "Executando Suite 1"
  mvn test > /dev/null &
  sleep 15

  cp tests/testng2.xml testng.xml
  echo "Executando Suite 2"
  mvn test > /dev/null &
  sleep 15

  cp tests/testng3.xml testng.xml
  echo "Executando Suite 3"
  mvn test > /dev/null &
  sleep 15

  cp tests/testng4.xml testng.xml
  echo "Executando Suite 4"
  mvn test > /dev/null &
  sleep 15

else

  cp tests/testng$1.xml testng.xml
  echo "Executando Suite $1"
  mvn test > /dev/null &

fi



