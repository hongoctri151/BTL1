<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".cook">

<androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar5"
        android:layout_width="411dp"
        android:layout_height="106dp"
        android:background="?attr/colorPrimary"
        android:minHeight="?attr/actionBarSize"
        android:theme="?attr/actionBarTheme"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

<ImageView
        android:id="@+id/imageView27"
                android:layout_width="120dp"
                android:layout_height="104dp"
                app:layout_constraintBottom_toBottomOf="@+id/toolbar5"
                app:layout_constraintEnd_toStartOf="@+id/textView7"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="parent"
                app:srcCompat="@drawable/usericon"
                android:contentDescription="TODO" />

<TextView
        android:id="@+id/textView7"
                android:layout_width="282dp"
                android:layout_height="104dp"
                android:background="#E32020"
                android:gravity="center"
                android:text="cook"
                android:textSize="36sp"
                android:textStyle="bold"
                app:layout_constraintBottom_toBottomOf="@+id/toolbar5"
                app:layout_constraintEnd_toEndOf="@+id/toolbar5"
                app:layout_constraintTop_toTopOf="@+id/toolbar5" />

<androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_end="463dp" />

<androidx.constraintlayout.widget.Guideline
        android:id="@+id/guideline2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:orientation="horizontal"
        app:layout_constraintGuide_begin="247dp" />

<TextView
        android:id="@+id/textView16"
                android:layout_width="79dp"
                android:layout_height="54dp"
                android:layout_marginTop="20dp"
                android:background="#190743"
                android:gravity="center"
                android:text="menu"
                android:textColor="#F8F8F8"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="@+id/guideline2" />

<ListView
        android:id="@+id/listviewMonAn"
                android:layout_width="0dp"
                android:layout_height="0dp"
                android:layout_marginTop="20dp"
                app:layout_constraintBottom_toBottomOf="parent"
                app:layout_constraintEnd_toEndOf="parent"
                app:layout_constraintHorizontal_bias="0.492"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toBottomOf="@+id/textView16"
                app:layout_constraintVertical_bias="0.834" />

<Button
        android:id="@+id/button14"
                android:layout_width="124dp"
                android:layout_height="64dp"
                android:onClick="updatemenu"
                android:text="UpdateMenu"
                app:layout_constraintBottom_toBottomOf="@+id/toolbar8"
                app:layout_constraintStart_toStartOf="parent"
                app:layout_constraintTop_toTopOf="@+id/toolbar8" />

<androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar8"
        android:layout_width="465dp"
        android:layout_height="wrap_content"
        android:layout_marginTop="36dp"
        android:background="?attr/colorPrimary"
        android:minHeight="?attr/actionBarSize"
        android:theme="?attr/actionBarTheme"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/toolbar5" />

<Button
        android:id="@+id/button15"
                android:layout_width="157dp"
                android:layout_height="59dp"
                android:text="Confirm"
                app:layout_constraintBottom_toBottomOf="@+id/toolbar8"
                app:layout_constraintStart_toEndOf="@+id/button14"
                app:layout_constraintTop_toTopOf="@+id/toolbar8" />

<Button
        android:id="@+id/button16"
                android:layout_width="152dp"
                android:layout_height="55dp"
                android:text="Note"
                app:layout_constraintBottom_toBottomOf="@+id/button15"
                app:layout_constraintEnd_toEndOf="@+id/toolbar8"
                app:layout_constraintStart_toEndOf="@+id/button15"
                app:layout_constraintTop_toTopOf="@+id/toolbar8" />

</androidx.constraintlayout.widget.ConstraintLayout>