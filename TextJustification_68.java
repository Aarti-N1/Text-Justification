package hard;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
		fullJustify(words,16);
	}
	

	    public static List<String> fullJustify(String[] words, int maxWidth) {
	        
	    int currLineStart = 0, numWordsCurrLine = 0, currLineLength = 0;
	    List<String> result = new ArrayList<>();
	    for (int i = 0; i < words.length; ++i) {
	      // currLineStart is the first word in the current line, and i is used to
	      // identify the last word.
	      ++numWordsCurrLine;
	      int lookaheadLineLength
	          = currLineLength + words[i].length() + (numWordsCurrLine - 1);
	      if (lookaheadLineLength == maxWidth) {
	        result.add(
	            joinALineWithSpace(words, currLineStart, i, i - currLineStart));
	        currLineStart = i + 1;
	        numWordsCurrLine = 0;
	        currLineLength = 0;
	      } else if (lookaheadLineLength > maxWidth) {
	        result.add(joinALineWithSpace(words, currLineStart, i - 1,
	        		maxWidth - currLineLength));
	        currLineStart = i;
	        numWordsCurrLine = 1;
	        currLineLength = words[i].length();
	      } else { // lookaheadLineLength < L.
	        currLineLength += words[i].length();
	      }
	    }

	    // Handles the last line. Last line is to be left-aligned.
	    if (numWordsCurrLine > 0) {
	      StringBuilder line = new StringBuilder(joinALineWithSpace(
	          words, currLineStart, words.length - 1, numWordsCurrLine - 1));
	      for (int i = 0; i < maxWidth - currLineLength - (numWordsCurrLine - 1); i++) {
	        line.append(' ');
	      }
	      result.add(line.toString());
	    }
	    return result;
	  }

	  // Joins strings in words[start : end] with numSpaces spaces spread evenly.
	  private static String joinALineWithSpace(String[] words, int start, int end,
	                                           int numSpaces) {
	    int numWordsCurrLine = end - start + 1;
	    StringBuilder line = new StringBuilder();
	    for (int i = start; i < end; ++i) {
	      line.append(words[i]);
	      --numWordsCurrLine;
	      int numCurrSpace = (int)Math.ceil((double)numSpaces / numWordsCurrLine);
	      for (int j = 0; j < numCurrSpace; j++) {
	        line.append(' ');
	      }
	      numSpaces -= numCurrSpace;
	    }
	    line.append(words[end]);
	    for (int i = 0; i < numSpaces; i++) {
	      line.append(' ');
	    }
	    return line.toString();
	  }
	    
	
}
