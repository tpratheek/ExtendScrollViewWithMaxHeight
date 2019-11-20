# ExtendScrollViewWithMaxHeight

Scroll View can be fixed for a particular height

# Installation

gradle project level:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
gradle module level: 

	dependencies {
	        implementation 'com.github.tpratheek:ExtendScrollViewWithMaxHeight:1.0.0'
	}


# Implementation

xml code:
	
	<com.pratheekt.library.ScrollerViewWithMaxHeight
		    android:layout_marginTop="25dp"
		    android:id="@+id/scroll_view"
		    android:padding="4dp"
		    app:maximumHeight="100dp"
		    android:paddingBottom="10dp"
		    android:layout_width="match_parent"
		    android:layout_height="wrap_content">

		<com.google.android.material.chip.ChipGroup
			android:id="@+id/chip_group"
			android:paddingStart="2dp"
			app:chipSpacingVertical="1dp"
			android:layout_width="wrap_content"
			android:layout_height="wrap_content"/>

	</com.pratheekt.library.ScrollerViewWithMaxHeight>


app:maximumHeight helps to fix the height of the Scroll view.


# Example
## For Chip Group
<a href="https://imgflip.com/gif/3gu5x7"><img src="https://i.imgflip.com/3gu5x7.gif" title="made at imgflip.com"/></a>

## For Text View
<a href="https://imgflip.com/gif/3gu63c"><img src="https://i.imgflip.com/3gu63c.gif" title="made at imgflip.com"/></a>
