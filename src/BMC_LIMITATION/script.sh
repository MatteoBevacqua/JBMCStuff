if [[ $# -ne 1 ]]; then
	echo "Input the number of unwindings"
	exit 1
fi
echo "Unwinding loops $1 times"
files=$(ls *.java)
dirs_to_remove=$(ls -d */)
echo "Removing folders : $dirs_to_remove"
rm -rf $dirs_to_remove
echo "Found files: " $files 
package=$(basename "$PWD")
for f in $files; do 
	file=$(basename $f .java)
	folder="${file}_results"
	mkdir "${folder}"
	echo $(javac $f -d $folder) 
	out="${file}_output.txt"
	jbmc $file --classpath "/lib/core-models.jar":"$folder": --unwind $1 --show-vcc --outfile "$folder/${file}_formula.txt" -java-threading > /dev/null
	jbmc $file --classpath "/lib/core-models.jar":"$folder": --unwind $1 --show-properties --outfile "$folder/${file}_formula.txt" -java-threading > "${folder}/${file}_properties.txt"
	jbmc $file --classpath "/lib/core-models.jar":"$folder": --unwind $1 --disable-uncaught-exception-check --stop-on-fail --java-threading --trace --graphml-witness "$folder/${file}.graphml"> $folder/$out
done


   