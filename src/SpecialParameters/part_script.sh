if [[ $# -ne 1 ]]; then
	echo "Need the unwinding parameter"
	exit 1
fi
files=$(ls *.java)
RED='\033[0;31m'
NC='\033[0m'
GREEN='\033[0;32m'
CC=0
echo "Unwinding loops $1 times"
files=$(ls PartialLoops.java)
echo "Found files: " $files 
package=$(basename "$PWD")
for f in $files; do 
	file=$(basename $f .java)
	folder="${file}_results"
	if [[ ! -d $folder ]]; then
		mkdir $folder
	fi
	echo $(javac $f -d $folder) 
	out="${file}_output.txt"
	#jbmc $file --classpath "/lib/core-models.jar:$folder" --unwind $1 --partial-loops --trace > $folder/$out
	jbmc $file --classpath "/lib/core-models.jar:$folder" --partial-loops --trace > $folder/$out
	line=$(cat $folder/$out | tail -n 1)
	if [[ "$line" == *"FAILED"* ]]; then
		CC=$RED
	else
		CC=$GREEN
	fi
	echo $f 
	echo -e "${CC}Verification output: $line ${NC}"
done

   