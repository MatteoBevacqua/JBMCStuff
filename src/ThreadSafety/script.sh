files=$(ls *.java)
echo "Found files: " $files 
package=$(basename "$PWD")
for f in $files; do 
	file=$(basename $f .java)
	echo $(javac $f)
	cd ..  
	out="${file}_output.txt"
	jbmc $package.$file --classpath "/lib/core-models.jar":".": --show-properties > "${package}/${file}_properties.txt"
	jbmc $package.$file --classpath "/lib/core-models.jar":".": --beautify --unwind 2000 -java-threading --trace --graphml-witness "$package/${file}.graphml"> $package/$out
	echo "jbmc $package.$file --classpath "/lib/core-models.jar":".": --beautify --unwind 2000 -java-threading --trace --graphml-witness "$package/${file}.graphml"> $package/$out"
	cd ./$package
done


jbmc ThreadSafety.SafeCritSemaphore --classpath /lib/core-models.jar:.: --property V.assertion.1 --unwind 2000 -java-threading --trace --graphml-witness ThreadSafety/SafeCritSemaphore.graphml> ThreadSafety/SafeCritSemaphore_output.txt