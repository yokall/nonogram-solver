use strict;
use warnings;

use Test2::V0;
use Test2::Tools::Compare;

use Nonogram::Clues;

subtest 'Valid clues file' => sub {
    plan tests => 2;

    my $filename = 'test_data/clues.yaml';
    my ( $row_clues, $column_clues ) = Nonogram::Clues::parse_clues_file($filename);

    is( $row_clues, [ [ 2, 1 ], [3], [ 1, 2 ], [1], [ 2, 1 ] ], 'Row clues parsed correctly' );

    is( $column_clues, [ [3], [ 1, 2 ], [ 2, 1 ], [1], [ 2, 1 ] ], 'Column clues parsed correctly' );
};

done_testing();
