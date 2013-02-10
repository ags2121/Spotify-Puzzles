//Alex Silva copyright (c) 2013
//with help from http://stackoverflow.com/questions/2548282/decimal-to-binary-and-vice-versa

#include <iostream>
#include <algorithm>
#include <math.h>
#include <stdexcept>

using namespace std;

//recursive decimal to binary function
string decToBin(int dec)
{
    if (dec < 1 || dec > 1000000000){
        throw invalid_argument("Decimal value is out of range!");
    }

    if ( dec == 0 ) return "0";
    if ( dec == 1 ) return "1";

    return ( dec % 2 == 0 ) ? decToBin(dec / 2) + "0" :
    decToBin(dec / 2) + "1";
}

int binToDec (string bin)
{
    //initialize result value and power value
    int res = 0, pow = 1;
    for ( int i = bin.length() - 1; i >= 0; --i, pow <<= 1 ){
        //evaluate binary digit, retrieve literal integer by converting from ascii value, multiply by power value, and add to output
        res += (bin[i] - '0') * pow;
    }

    return res;
}


int main()
{
    int dIn;

    cout<<"";

    cin>>dIn;

    try {
        string strBin = decToBin(dIn);

        reverse(strBin.begin(), strBin.end());

        cout << binToDec(strBin) << endl;

    } catch (invalid_argument &e) {
        cerr << e.what() << endl;
    }

}
