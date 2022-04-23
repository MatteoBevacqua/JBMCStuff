files=$(ls *.java)
RED='\033[0;31m'
NC='\033[0m'
GREEN='\033[0;32m'
YELLOW='\033[0;33m'
CC=0 
echo -e "${YELLOW}Found files:"
echo -e "${files} ${NC}" 
package=$(basename "$PWD")
for f in $files; do 
	file=$(basename $f .java)
	folder="${file}_results"
	if [[ ! -d $folder ]]; then
		mkdir $folder
	fi
	echo $(javac $f -d $folder) 
	out="${file}_output.txt"
	jbmc $file --classpath "/lib/core-models.jar:$folder" --disable-uncaught-exception-check --stop-on-fail --java-threading --trace > $folder/$out
	line=$(cat $folder/$out | tail -n 1)
	if [[ "$line" == *"FAILED"* ]]; then
		CC=$RED
	else
		CC=$GREEN
	fi
	echo $f 
	echo -e "${CC}Verification output: $line ${NC}"
done


   