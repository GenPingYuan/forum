import React,{PureComponent} from 'react'
import Head from '../pages/components/Head'

class BasicLayout extends PureComponent{
    constructor(props){
        super(props);
    }

    render(){
        return(
            <div>
                <Head/>
                {/* <CopyRight/> */}
            </div>
        )
    }

}

export default BasicLayout