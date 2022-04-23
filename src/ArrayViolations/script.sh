files=$(ls *.java)
RED='\033[0;31m'
NC='\033[0m'
GREEN='\033[0;32m'
CC=0
echo "Found files: " $files 
package=$(basename "$PWD")
for f in $files; do 
	file=$(basename $f .java)
	folder="${file}_results"
	if [[ ! -d $folder ]]; then
		mkdir $folder
	fi
	mkdir "${folder}"
	echo $(javac $f -d $folder) 
	out="${file}_output.txt"
	jbmc $file --classpath "/lib/core-models.jar":"$folder": --stop-on-fail --trace > $folder/$out
	line=$(cat $folder/$out | tail -n 1)
	if [[ "$line" == *"FAILED"* ]]; then
		CC=$RED
	else
		CC=$GREEN
	fi
	echo $f 
	echo -e "${CC}Verification output: $line ${NC}"
done


   	