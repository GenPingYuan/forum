import React,{ PureComponent } from 'react';
import Head from './Head';
import {connect} from 'dva';

class Index extends PureComponent {
    constructor(props){
        super(props)
        console.log(this.props);
    }

    
    singin = (e) => {
        // console.log(e.keyCode);
        // console.log(e.keyCode);
        if(e.keyCode == 13){
            // alert(1111);
            this.props.dispatch({type: "app/signin",username: e.target.value});
            // console.log(this.props.app.username);
        }
    }

    render(){
        return (
            <div>
                <Head/>
                <input type="text" name="username" onKeyUp = {this.singin}/>
                {this.props.app.username}
            </div>
        )
    }
}

export default connect(({head,app}) => ({head,app}))(Index)