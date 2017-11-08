import psycopg2, random
from datetime import date
con=psycopg2.connect(database="senhas", user="jucapoid", password="1ateaooito", host="127.0.0.1", port="5432")
dbcursor=con.cursor()
def listusers():
    dbcursor.execute('select * from users')
    rows = dbcursor.fetchall()
    for row in rows:
        print " --------------------"+row[0]+"---------------------"
        print "| Email: "+row[2]+"\t\t|\n| Nome: "+row[3]+"\t\t\t\t\t|\n| Creditos: "+ str(row[4]) +"\t\t\t\t|"
        print " -----------------------------------------------"

def createuser(username, password, name):
    dbcursor.execute("insert into users (username,password,email,name) values ('" + str(username) + "','" + str(password) + "','" + str(username) + "@alunos.uevora.pt','" + str(name) + "');")
    con.commit()

def dropuser(username=None,email=None):
    if username==None and email==None:
        print "Por favor indique o username ou o email do utilizador"
    elif username!=None and email==None:
        dbcursor.execute("delete from users where username='"+ str(username) + "';")
    elif username==None and email!=None:
        dbcursor.execute("delete from users where email='"+ str(username) + "';")
    con.commit()

def carregar(username,valor):
    dbcursor.execute("update users set credito='"+valor+"' where username='"+username+"';")
    con.commit()

def getcredito(username):
    try:
        dbcursor.execute("select credito from users where username='"+str(username)+"';")
        credito = dbcursor.fetchone()[0]
        return credito
    except:
        print "There is no such user"

def setprice(dia):
    price = 0
    if dia==date.today():
        price = 2.7
    else:
        price = 2.4
    return price

def buysenha(username, dia, refeicao, opcao):
    credito = getcredito(username)
    price = setprice(dia)
    if credito < price:
        print "O utilizador nao tem credito suficiente"
    else:
        senhaid = generatesenha(username,opcao,refeicao,dia)
    if opcao==0:
        op='Prato Principal'
    elif opcao==1:
        op='Menu Dieta'
    elif opcao==2:
        op='Opção do Dia'
    elif opcao==3:
        op='Vegetariano'
    elif opcao==4:
        op='Menu Vegetariano'
    if refeicao==0:
        refei='Almoço'
    elif refeicao==1:
        refei='Jantar'
    if dia=='0':
        dia='Segunda-feira'
    elif dia=='1':
        dia='Terça-feira'
    elif dia=='2':
        dia='Quarta-feira'
    elif dia=='3':
        dia='Quinta-feira'
    elif dia=='4':
        dia='Sexta-feira'
    elif dia=='5':
        dia='Sábado'
    try:
        dbcursor.execute("insert into senhas values('" + str(senhaid) + "','" + str(dia) + "','" + str(refei) + "','" + str(opcao) + "');")
        con.commit()
    except:
        print "Senha Repetida"
    dbcursor.execute("update users set credito='"+str(float(credito)-float(price))+"' where username='"+username+"';")
    con.commit()
    try:
        dbcursor.execute("select credito from users where username='"+str(username)+"';")
        credito = dbcursor.fetchone()[0]
        print "O utilizador " + username + " ficou com " + str(credito) + " euros"
    except:
        print "There is no such user"

def generatesenha(username,opcao,refeicao,dia):
    id = username + dia + opcao + refeicao
    id = id.join(random.choice('0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ')  for i in range(11))
    return id

def closecon():
    con.close()
