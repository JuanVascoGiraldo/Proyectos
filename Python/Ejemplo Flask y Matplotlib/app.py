import io
import matplotlib.pyplot as plt
from numpy import *
from flask import Flask, render_template, make_response


app = Flask(__name__)
plt.style.use('fivethirtyeight')


@app.route('/simple.png')
def simple_image():

    def beta1(x,y):
        term1 = x-average(x)
        term2= y-average(y)
        Sxy = sum(term1*term2)
        Sxx = sum(term1*term1)
        return Sxy/Sxx

    def beta0(x,y):
        return average(y)-beta1(x,y)*average(x)

    def plot_recta(x,y):
        b1 = beta1(x,y)
        b0 = beta0(x,y)
        pnts_x = linspace(x[0],x[-1],100)
        pnts_y = b0 + b1 * pnts_x
        plt.plot(pnts_x,pnts_y)
        plt.plot(x,y,'r*')

    x = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
    y = (334,2203,9993,4626,3961,3943,938,4744,4881,5624,675,8091,3680,4090,66,9479,9117,2759,7270,7849,1093,7508,2737,5062,3032,2541,9445,4440,7192,6746)

    num_y = int(len(y))

    if num_y >= 10:
        plot_recta(x,y)

    else:
        print("You need more than 10 values to make a prediction")
    buffer = io.BytesIO()
    plt.savefig(buffer, format='png')
    buffer.seek(0)
    plt.close()

    response = make_response(buffer.getvalue())
    response.mimetype = 'image/png'

    return response


@app.route('/')
def index():
    return render_template(
        'index.html',
        title='Your progress'
    )



if __name__ == '__main__':
    import sys

    app.run(debug='d' in sys.argv[-1])