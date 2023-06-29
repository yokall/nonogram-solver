#!/usr/bin/env perl

use strict;
use warnings;

# Example nonogram grid and clues
my @grid         = ( [ 0, 1, 1, 1, 0 ], [ 1, 0, 1, 0, 1 ], [ 0, 1, 1, 1, 0 ], [ 0, 1, 0, 1, 0 ], [ 1, 0, 0, 0, 1 ] );
my @row_clues    = ( [3], [ 1, 1, 1 ], [3], [ 1, 1 ], [ 1, 1 ] );
my @column_clues = ( [ 1, 1 ], [ 1, 2 ], [3], [ 1, 2 ], [ 1, 1 ] );

# Display the nonogram grid with clues
my $size = scalar @grid;

# Calculate the maximum number of clues for any column
my $max_col_clues = 0;
foreach my $col_clue (@column_clues) {
    my $num_clues = scalar @$col_clue;
    $max_col_clues = $num_clues if $num_clues > $max_col_clues;
}

# Calculate the maximum number of clues for any row
my $max_row_clues = 0;
foreach my $row_clue (@row_clues) {
    my $num_clues = scalar @$row_clue;
    $max_row_clues = $num_clues if $num_clues > $max_row_clues;
}

# Print column clues
for ( my $i = 0; $i < $max_col_clues; $i++ ) {
    print '  ' x $max_row_clues;
    for ( my $j = 0; $j < $size; $j++ ) {
        my $col_clue  = $column_clues[$j];
        my $num_clues = scalar @$col_clue;
        my $clue      = $num_clues > $i ? $col_clue->[$i] : " ";
        print "$clue ";
    }
    print "\n";
}

# Print row clues and grid
for ( my $i = 0; $i < $size; $i++ ) {
    my @this_row_clues = @{ $row_clues[$i] };

    if ( scalar @this_row_clues < $max_row_clues ) {
        for ( 1 .. ( $max_row_clues - scalar @this_row_clues ) ) {
            print "  ";
        }
    }

    # Print row clues
    for my $clue (@this_row_clues) {
        print "$clue ";
    }

    # Print grid
    for ( my $j = 0; $j < $size; $j++ ) {
        my $cell = $grid[$i][$j];
        if ($cell) {
            print "# ";
        }
        else {
            print "  ";
        }
    }

    print "\n";
}

