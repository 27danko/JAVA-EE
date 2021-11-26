var reader; 
    
    function checkFileAPI() {
        if (window.File && window.FileReader && window.FileList && window.Blob) {
            reader = new FileReader();
            return true; 
        } else {
            alert('ERROR');
            return false;
        }
    }

    
    function readText(filePath) {
        var output = ""; 
        if(filePath.files && filePath.files[0]) {           
            reader.onload = function (e) {
                output = e.target.result;
                displayContents(output);
            };//end onload()
            reader.readAsText(filePath.files[0]);
        }
        else if(ActiveXObject && filePath) { 
            try {
                reader = new ActiveXObject("Scripting.FileSystemObject");
                var file = reader.OpenTextFile(filePath, 1); 
                output = file.ReadAll(); 
                file.Close(); 
                displayContents(output);
            } catch (e) {
                if (e.number == -2146827859) {
                    alert('ERROR'); 
                }
            }       
        }
        else { 
            return false;
        }       
        return true;
    }   


    function displayContents(txt) {
        var el = document.getElementById('main'); 
        el.innerHTML = txt;
    }
          function getStats() {
            var text = main.value,
              chars = text.length,
              words = text.split(/\s+/g).length,
              lines = text.split("\n").length;
              
              
            document.getElementById("textfile").innerHTML = lines + " lines, " + words + " words, " + chars + " chars"; 
            document.getElementById("textfile2").innerHTML =  JSON.stringify(wordFreq(text)); 
            stats(text,words);  
          }
          
           
          function stats(text,words){
           text = text.toLowerCase();
            console.log(wordFreq(text));
            var freq = wordFreq(text)
            Object.keys(freq).sort().forEach(function(word) {
              console.log(" This word [ " + word + " ] occurs " + freq[word] +" times | | STATS = " + ((freq[word] / words)*100).toPrecision(2) +" % " );  
          });
            
          
          }
          

          function wordFreq(text) {
            var words = text.replace(/[.]/g, '').split(/\s/);
            var freqMap = {};
            words.forEach(function(w) {
                if (!freqMap[w]) {
                    freqMap[w] = 0;
                }
                freqMap[w] += 1;
            });
        
            return freqMap;
        }
        


         
        
    