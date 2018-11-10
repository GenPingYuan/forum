import React,{ PureComponent } from 'react';
import Head from './Head';
import {connect} from 'dva';

class Index extends PureComponent {
    constructor(props){
        super(props)
        console.log(this.props);
    }

    render(){
        return (<Head/>)
    }
}

export default connect(({head}) => ({head}))(Index)