<?php
use PHPUnit\Framework\TestCase;

class AuthBasicTest extends TestCase {

    private $instance;

    public function setUp() : void {
        $this->instance = new AuthBasic();
    }

    public function tearDown() : void {
        unset($this->instance);
    }

public function testCreateCode(){
    $out = $this->instance->createCode();
    $this->assertEquals(6, strlen($out));

    $out = $this->instance->createCode(6);
    $this->assertEquals(6, strlen($out));

    $out = $this->instance->createCode(8);
    $this->assertEquals(8, strlen($out));
}


    public function testCreateAuthToken(){
        $exp = array(
            'emlAuth'=>'test@example.com','authCode'=>'131313',
            'authDate'=>date("Y-m-d"),'authHour'=>date("H:i:s"),
            'addrIp'=>'127.0.0.1','reqOs'=>'Linux','reqBrw'=>'FF'
        );

        $out = $this->instance->createAuthToken('test@example.com', 1);
        $out['authCode'] = '131313'; // stała wartość dla testu

        $this->assertEquals($exp, $out);
    }

    public function testVerifyQuickRegCode(){
        $this->assertTrue($this->instance->verifyQuickRegCode("123456"));
        $this->assertFalse($this->instance->verifyQuickRegCode("123"));
        $this->assertFalse($this->instance->verifyQuickRegCode("12345678"));
        $this->assertFalse($this->instance->verifyQuickRegCode("ABCDEF"));
    }
}
