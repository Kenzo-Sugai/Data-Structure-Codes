// C++ code
//

char compare(String s){
  if(s == ".----") return '1';
  if(s == "..---") return '2';
  if(s == "...--") return '3';
  if(s == "....-") return '4';
  if(s == ".....") return '5';
  if(s == "-....") return '6';
  if(s == "--...") return '7';
  if(s == "---..") return '8';
  if(s == "----.") return '9';
  if(s == "-----") return '0';
}

void ponto(){
  digitalWrite(4, HIGH);
  delay(3000);
  digitalWrite(4, LOW);
  delay(2000);
}
void barra(){
  digitalWrite(4, HIGH);
  delay(6000);
  digitalWrite(4, LOW);
  delay(2000);
}

void piscadinha(int i){
  switch(i){
    case 1:
      ponto(); barra(); barra(); barra(); barra();
      break;
    case 2:
      ponto(); ponto(); barra(); barra(); barra();
      break;
    case 3:
      ponto(); ponto(); ponto(); barra(); barra();
      break;
    case 4:
      ponto(); ponto(); ponto(); ponto(); barra();
      break;
    case 5:
      ponto(); ponto(); ponto(); ponto(); ponto();
      break;
    case 6:
      barra(); ponto(); ponto(); ponto(); ponto();
      break;
    case 7:
      barra(); barra(); ponto(); ponto(); ponto();
      break;
    case 8:
      barra(); barra(); barra(); ponto(); ponto();
      break;
    case 9:
      barra(); barra(); barra(); barra(); ponto();
      break;
    case 0:
      barra(); barra(); barra(); barra(); barra();
      break;
  }
}


double luz = 0;
int tempo_luz = 0;
double total = 0;
int cnt = 0;
bool check = false;
String s = "";
void setup()
{
  pinMode(A4, INPUT);
  pinMode(4, OUTPUT);
  Serial.begin(9600);
}

void loop()
{
  luz = analogRead(A4);
  //Serial.println(luz);
  //Serial.println(luz);
  if(luz < 720 and !check){
   tempo_luz = millis();
   check = true; 
  } 
  else if(luz >= 720 and check){
    luz = millis() - tempo_luz;
    if(luz <= 3000) s += '.';
    else s += '-';
    check = false;
    Serial.println(s);
  }
  
  if(s.length() == 5){
    Serial.println(compare(s));
    s = "";
  }
  
}
