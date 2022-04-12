files=$(ls *.java)
echo "Found files: " $files 
package=$(basename "$PWD")
for f in $files; do 
	file=$(basename $f .java)
	echo $(javac $f)
	cd ..  
	out="${file}_output.txt"
	jbmc $package.$file --classpath "/lib/core-models.jar":".": --unwind 2000 -java-threading --trace --graphml-witness "$package/${file}.graphml"> $package/$out
	cd ./$package
done